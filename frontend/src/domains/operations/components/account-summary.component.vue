<template>
  <pv-card class="account-card">
    <template #header>
      <div class="card-header">
        {{ $t('accountType') }}: <strong>{{ account.accountType }}</strong>
      </div>
    </template>

    <template #content>
      <div class="card-content">
        <p class="account-number">
          {{ $t('accountNumber') }}: <strong>{{ account.accountNumber }}</strong>
        </p>
        <p class="balance">
          {{ $t('balance') }}: <strong>${{ account.balance.toFixed(2) }}</strong>
        </p>
      </div>
    </template>

    <template #footer>
      <div class="card-footer">
        <p>{{ $t('totalTransactions') }}: <strong>{{ total }}</strong></p>
        <p>{{ $t('successRate') }}: <strong>{{ rate }}%</strong></p>
      </div>
    </template>
  </pv-card>
</template>

<script>
import TransactionService from '../services/transaction.service'

export default {
  props: ['account'],
  data() {
    return {
      total: 0,
      rate: 0
    }
  },
  async mounted() {
    const txs = await TransactionService.fetchByAccount(this.account.id)
    this.total = txs.length
    const success = txs.filter(t => t.status === 'success').length
    this.rate = this.total ? Math.round((success / this.total) * 100) : 0
  }
}
</script>
<style scoped>
.account-card {
  border: 1px solid #cbd5e0; 
  border-radius: 10px;
  padding: 1rem;
  background-color: #f7fafc;
  transition: box-shadow 0.3s ease;
}

.account-card:hover {
  box-shadow: 0 2px 12px rgba(66, 153, 225, 0.3);
}

.card-header {
  font-size: 1.2rem;
  font-weight: bold;
  color: #2a4365;
  margin-bottom: 0.5rem;
}

.card-content {
  margin-bottom: 1rem;
}

.account-number {
  font-size: 1rem;
  font-weight: bold;
  color: #2c5282;
  margin: 0.25rem 0;
}

.balance {
  font-size: 1.1rem;
  color: #3182ce;
  font-weight: bold;
}

.card-footer {
  font-size: 0.95rem;
  color: #4a5568;
  border-top: 1px solid #e2e8f0;
  padding-top: 0.5rem;
}
</style>
