<template>
  <pv-toolbar>
    <template #start>
      <img :src="logoUrl" alt="Logo" style="height: 30px" />
    </template>

    <template #center>
      <div class="nav-links">
        <router-link to="/home">{{ $t('home') }}</router-link>
        <router-link to="/transactions/execute">{{ $t('transaction') }}</router-link>
      </div>
    </template>

    <template #end>
      <pv-select
          v-model="selectedLang"
          :options="langs"
          class="w-8rem"
          @change="changeLang"
          optionLabel="label"
          optionValue="code"
      />
    </template>
  </pv-toolbar>
</template>

<script>
export default {
  data() {
    return {
      langs: [
        { label: 'EN', code: 'en' },
        { label: 'ES', code: 'es' }
      ],
      selectedLang: this.$i18n.locale
    }
  },
  computed: {
    logoUrl() {
      return 'https://logo.clearbit.com/withflow.com'
    }
  },
  methods: {
    changeLang() {
      this.$i18n.locale = this.selectedLang
    }
  }
}
</script>

<style scoped>
.nav-links {
  display: flex;
  gap: 1.5rem;
  align-items: center;
}

.nav-links a {
  text-decoration: none;
  color: #333;
  font-weight: 500;
  transition: color 0.2s;
}

.nav-links a:hover {
  color: #007bff;
}
</style>