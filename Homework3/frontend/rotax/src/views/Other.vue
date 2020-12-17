<template>
  <div>
    <h3>Останато</h3> <br> <br>
    <ul id="otherList">
      <li v-for="other in filteredOther" :key="other.name">
        {{ other.name }}
      </li>
    </ul>
  </div>
</template>

<script>
import other from '@/data/objects'
export default {
  data () {
    return {
      other,
      filteredOther
    }
  }
}

var filteredOther = []
for (let i = 0; i < other.length; i++) {
  if (other[i].category === 'other') {
    filteredOther.push(other[i])
  }
}
</script>
