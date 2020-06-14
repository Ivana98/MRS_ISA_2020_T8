import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Examination } from 'src/app/model/examination';
import { LoginService } from '../login-service/login.service';
import { MedicalRecordExamination } from 'src/app/model/medicalRecordExamination';
import { ExaminationRequest, ExaminationRequestDisplay } from 'src/app/model/examinationRequest';
import { ApiService } from '../api-services/api.service';

@Injectable({
  providedIn: 'root'
})
export class ExaminationService {

  private _url: string = "http://localhost:8080/api/examinations/";

  constructor(private _httpClient: HttpClient, private _loginService: LoginService, private _apiService : ApiService) { }

  /**
   * Adding one click free examination.
   * 
   * @param examination is Examination
   * @returns added Examination or null if not added.
   */
  public addFreeExamination(examination) {
    return this._httpClient.post<Examination>(this._url + "saveOneClickExamination", examination);
  }

  public loadAllFreeExaminationsFromClinic() {
    return this._httpClient.get<Array<Examination>>(this._url + "getAllFreeFromClinic/" + this._loginService.currentUser.clinicId);
  }

  /**
   * Delete examination by id.
   * 
   * @param id is Examination ID
   */
  public delete(id) {
    return this._httpClient.delete(this._url + "delete/" + id);
  }

  /**
   * Return true if doctor had examinations in past with choosen patient.
   * 
   * @param patientId id patient id
   */
  public checkIfDoctorCanOpenMedicalRecord(patientId) {
    return this._httpClient.get<Boolean>(this._url + "checkIfDoctorCanOpenMedicalRecord/" + patientId + "/" + this._loginService.currentUser.userId);
  }

  /**
   * Load all examinations from patient.
   * 
   * @param patientId 
   */
  public loadPatientExaminations(patientId) {
    return this._httpClient.get<Array<MedicalRecordExamination>>(this._url + "loadPatientExaminations/" + patientId);
  }

  /**
   * Return true if current doctor is patient's doctor.
   * 
   * @param patientId is patient id
   */
  public canDoctorExaminate(patientId) {
    return this._httpClient.get<boolean>(this._url + "canDoctorExaminate/" + patientId + "/" + this._loginService.currentUser.userId);
  }

  /**
   * Load number of examinations from clinin in last 24 hours.
   * 
   * return list of 24 numbers
   */
  public loadDailyExaminations(now) {
    return this._httpClient.get<Array<Number>>(this._url + "loadDailyExaminations/" + this._loginService.currentUser.clinicId + "/" + now);
  }

  /**
   * 
   * @param now 
   */
  public get24HourList(now) {
    return this._httpClient.get<Array<String>>(this._url + "get24HourList/" + now);
  }

  /**
   * Load number of examinations from clinin in last 7 days.
   * 
   * return list of 7 numbers
   */
  public loadWeeklyExaminations(now) {
    return this._httpClient.get<Array<Number>>(this._url + "loadWeeklyExaminations/" + this._loginService.currentUser.clinicId + "/" + now);
  }

  /**
   * 
   * @param now 
   */
  public get7DaysList(now) {
    return this._httpClient.get<Array<String>>(this._url + "get7DaysList/" + now);
  }

  /**
   * Load number of examinations from clinin in last 7 days.
   * 
   * return list of 7 numbers
   */
  public loadAnnualExaminations(now) {
    return this._httpClient.get<Array<Number>>(this._url + "loadAnnualExaminations/" + this._loginService.currentUser.clinicId + "/" + now);
  }

  /**
   * 
   * @param now 
   */
  public get12MonthsList(now) {
    return this._httpClient.get<Array<String>>(this._url + "get12MonthsList/" + now);
  }

  /**
   * 
   * @param examinationRequest 
   */
  public sendExaminationRequest(examinationRequest) {
    examinationRequest.doctorId = this._loginService.currentUser.userId;
    examinationRequest.clinicId = this._loginService.currentUser.clinicId;
    
    return this._httpClient.post<ExaminationRequest>(this._url + "sendExaminationRequest", examinationRequest)
  }

  /**
   * Load all examination request from clinic.
   */
  public loadAllExaminationRequest() {
    return this._httpClient.get<Array<ExaminationRequestDisplay>>(this._url + "loadAllExaminationRequest/" + this._loginService.currentUser.clinicId);
  }

  /**
   * 
   * @param examinationRequest
   */
  public denyRequestedExamination(examinationRequest) {
    return this._httpClient.put<Boolean>(this._url + "denyExaminationRequest", examinationRequest.id);
  }

  /**
   * 
   * @param examinationRequest 
   */
  public approveRequestedExamination(approvedRequestedExamination) {
    approvedRequestedExamination.clinicId = this._loginService.currentUser.clinicId;
    
    return this._httpClient.put<Boolean>(this._url + "approveExaminationRequest", approvedRequestedExamination);
  }

  //patient send request for eamination
  public patientSendExaminRequest(examin : ExaminationRequest){
    return this._apiService.post(this._url + "sendExaminationRequest", examin, this._apiService.headers);
  }

}
