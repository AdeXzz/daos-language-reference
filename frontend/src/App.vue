<template>
  <div>

    <router-view />
  </div>
</template>

<script>
import TheToolbar from './domains/public/components/the-toolbar.component.vue'

export default {
  components: {
    TheToolbar
  }
}
</script>