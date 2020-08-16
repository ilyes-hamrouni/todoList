import { Component, OnInit } from '@angular/core';
import { Task } from 'src/app/modals/task';
import { TodoService } from 'src/app/services/todo.service';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {
  task:Task;
  tasks:Task[] =[];

  constructor(private todoService:TodoService) { }

  ngOnInit(): void {
    this.getTasks();
  }

  addTask(description){

     this.task = new Task();
    this.task.description = description.value;
    console.log("task object: ",this.task);
    
    this.todoService.createTask(this.task).subscribe(
      (data:Task)=> {
        this.tasks.push(data);
        
      }
    )

  }

  getTasks(){
    this.todoService.getAllTasks().subscribe(
      (data:Task[])=> {
        this.tasks = data;
        console.log(data);
        
      }
    )
  }

  updateTask(){

  }

  deleteTask(id:number){
    this.todoService.deleteTask(id).subscribe
    (
    (data)=> {
      console.log(data);
      
    }
    )
  }

 

}
