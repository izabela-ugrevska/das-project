<template>
  <div>
    <h3>Кафулиња</h3> <br> <br>
    <ul id="cafeList">
      <li v-for="cafe in filteredCafes" :key="cafe.name">
        {{ cafe.name }}
      </li>
    </ul>
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
