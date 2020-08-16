import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TaskComponent } from './components/task/task.component';
import { TaskDetailsComponent } from './components/task-details/task-details.component';


const routes: Routes = [
  {
    path: "task",
    component: TaskComponent,

  },
  {
    path: "task-details/:id",
    component: TaskDetailsComponent
  }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
