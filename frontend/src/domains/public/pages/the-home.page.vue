<template>
  <div class="home-container">
    <the-toolbar />
    <h1 class="page-title">{{ $t('home') }}</h1>
    <p class="welcome-text">{{ $t('welcome') }}</p>
    <h2 class="section-title">{{ $t('accountOverview') }}</h2>
    <div class="account-grid">
      <account-summary
          v-for="acc in accounts"
          :key="acc.id"
          :account="acc"
      />
    </div>
  </div>
</template>

<script>
import TheToolbar from '../components/the-toolbar.component.vue'
import AccountSummary from '@/domains/operations/components/account-summary.component.vue'
import AccountService from '@/domains/operations/services/account.service'

export default {
  components: { TheToolbar, AccountSummary },
  data() {
    return {
      accounts: []
    }
  },
  async mounted() {
    this.accounts = await AccountService.fetchAll()
  }
}
</script>

<style scoped>
.home-container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 2rem;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  background-color: #ffffff;
  color: #333;
}

.page-title {
  font-size: 2rem;
  font-weight: bold;
  margin-bottom: 0.5rem;
  color: #2c3e50;
}

.welcome-text {
  font-size: 1.1rem;
  margin-bottom: 1.5rem;
  color: #555;
}

.section-title {
  font-size: 1.5rem;
  margin: 2rem 0 1rem;
  color: #34495e;
}

.account-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
  gap: 1.5rem;
}
</style>