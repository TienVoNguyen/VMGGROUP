<template>
    <div class="submit-form">
      <div v-if="!submitted">
        <div class="form-group">
          <label for="title">Title</label>
          <input
            type="text"
            class="form-control"
            id="title"
            required
            v-model="todo.title"
            name="title"
          />
        </div>

        <div class="form-group">
          <label for="description">Description</label>
          <input
            class="form-control"
            id="description"
            required
            v-model="todo.description"
            name="description"
          />
        </div>

        <button @click="saveTodo" class="btn btn-success">Submit</button>
      </div>

      <div v-else>
        <h4>You submitted successfully!</h4>
        <button class="btn btn-success" @click="newTodo">Add</button>
      </div>
    </div>
  </template>

  <script>
  import TodoDataService from '@/service/TodoDataService';

  export default {
    name: "add-todo",
    data() {
      return {
        todo: {
          id: null,
          title: "",
          description: "",
          lastModified: "",
          dateCreated: "",
          todoStatus: "",
        },
        submitted: false
      };
    },
    methods: {
      saveTodo() {
        var data = {
            title: this.todo.title,
            description: this.todo.description,
            lastModified: new Date(),
            dateCreated: new Date(),
            todoStatus: "COMPLETED"
        };

        TodoDataService.create(data)
          .then(response => {
            this.todo.id = response.data.id;
            console.log(response.data);
            this.submitted = true;
          })
          .catch(e => {
            console.log(e);
          });
      },

      newTodo() {
        this.todo = {};
        this.submitted = false;
      }
    }
  };
  </script>

  <style>
  .submit-form {
    max-width: 300px;
    margin: auto;
  }
  </style>