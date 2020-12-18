<template>
  <div>
    <h1>Останато</h1>
    <b-table hover :items="filteredOther">
      <template #cell(name)="data">
        <router-link :to="`/objects/:${data.value}`">{{ data.value }}</router-link>
      </template>
    </b-table>
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
