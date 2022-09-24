<template>
  <center id="app">
    <h1 style="color: green">Nguyen Tien Vo</h1>
    <h2><u>To Do List</u></h2>
    <Task task="Chay 1km" index="0" />
    <Task task="Code tren VMG" index="1" />
    <Task task="Clean Room" index="2" />
    <Task task="Go to Swim" index="3" />
    <Task task="Buy Dog Food" index="4" />
  </center>
</template>

<script>
import Task from "./components/Task";
export default {
  name: "App",
  components: { Task },
};
</script>
