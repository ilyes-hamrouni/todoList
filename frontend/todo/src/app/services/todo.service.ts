import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Task } from '../modals/task';

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  constructor(private httpClient:HttpClient) { }

   _url="http://localhost:8080/task";

  getTaskById(id:number){
    return this.httpClient.get(this._url+"/"+id);
  }
  getAllTasks(){
    return this.httpClient.get(this._url+"/all");
  }
  createTask(task:Task){
    return this.httpClient.post(this._url,task);
  }
  updateTask(task:Task){
    return this.httpClient.put(this._url,task);
  }
  deleteTask(id:number){
    return this.httpClient.delete(this._url+"/"+id);
  }
}
