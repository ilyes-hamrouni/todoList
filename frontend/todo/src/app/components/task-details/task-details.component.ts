import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TodoService } from 'src/app/services/todo.service';
import { Task } from 'src/app/modals/task';

@Component({
  selector: 'app-task-details',
  templateUrl: './task-details.component.html',
  styleUrls: ['./task-details.component.css']
})
export class TaskDetailsComponent implements OnInit {

  routeparam: any;
  task:Task;
  constructor(private activatedRoute: ActivatedRoute,private todoService:TodoService) { }

  ngOnInit(): void {
    this.routeparam = this.activatedRoute.snapshot.params.id;
    this.getTask();
  }

  getTask(){
    this.todoService.getTaskById(this.routeparam).subscribe(
      (data:Task) => {
        this.task = data;
        console.log(this.task);
        
      }
    )
  }

}
