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
  border: 1px solid #ddd;
  border-radius: 10px;
  padding: 1rem;
  background-color: #f9f9f9;
  transition: box-shadow 0.3s ease;
}

.account-card:hover {
  box-shadow: 0 2px 12px rgba(0, 0, 0, 0.15);
}

.card-header {
  font-size: 1.2rem;
  font-weight: bold;
  color: #2c3e50;
  margin-bottom: 0.5rem;
}

.card-content {
  margin-bottom: 1rem;
}

.account-number {
  font-size: 1rem;
  font-weight: bold;
  color: #34495e;
  margin: 0.25rem 0;
}

.balance {
  font-size: 1.1rem;
  color: #27ae60;
  font-weight: bold;
}

.card-footer {
  font-size: 0.95rem;
  color: #555;
  border-top: 1px solid #ccc;
  padding-top: 0.5rem;
}
</style>