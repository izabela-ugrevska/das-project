<template>
  <div>
    <h1>Кафулиња</h1>
    <b-table hover :items="filteredCafes">
      <template #cell(name)="data">
        <router-link :to="`/objects/:${data.value}`">{{ data.value }}</router-link>
      </template>
    </b-table>
  </div>
</template>

<script>
import cafes from '@/data/objects'
export default {
  data () {
    return {
      cafes,
      filteredCafes
    }
  }
}

var filteredCafes = []
for (let i = 0; i < cafes.length; i++) {
  if (cafes[i].category === 'cafe') {
    filteredCafes.push(cafes[i])
  }
}
</script>
