<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">Дома</router-link> |
      <router-link to="/restaurants">Ресторани</router-link> |
      <router-link to="/cafes">Кафе-барови</router-link> |
      <router-link to="/markets">Маркети</router-link> |
      <router-link to="/other">Останато</router-link> |
    </div>
    <router-view/>
  </div>
</template>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: darkcyan;
}

#nav {
  padding: 10px;
  background: lightgray;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: darkcyan;
    }
  }
}
</style>
