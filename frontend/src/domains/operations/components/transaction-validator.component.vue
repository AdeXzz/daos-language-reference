<template>
  <div class="transaction-validator-container">
    <h2 class="transaction-validator-title" aria-label="Transaction Validation">{{ $t("transactionValidation") }}</h2>

    <div class="transaction-validator-input-wrapper">
      <pv-input-text
          v-model="inputId"
          :placeholder="$t('transactionId')"
          aria-label="Transaction ID Input"
          class="transaction-validator-input"
      />
    </div>

    <pv-button
        label="Execute Transaction"
        icon="pi pi-check"
        class="transaction-validator-button"
        @click="execute"
    />

    <div v-if="message" class="transaction-validator-message">{{ message }}</div>

    <div v-if="data" class="transaction-validator-data">
      <p><strong>{{ $t("accountId") }}:</strong> {{ data.accountId }}</p>
      <p><strong>{{ $t("accountType") }}:</strong> {{ data.accountType }}</p>
      <p><strong>{{ $t("accountNumber") }}:</strong> {{ data.accountNumber }}</p>
      <p><strong>{{ $t("amount") }}:</strong> {{ data.amount }}</p>
      <p><strong>{{ $t("executedAt") }}:</strong> {{ data.executedAt }}</p>
      <p><strong>{{ $t("status") }}:</strong> {{ data.status }}</p>
    </div>
  </div>
</template>

<script>
import TransactionService from '@/domains/operations/services/transaction.service'
import AccountService from '@/domains/operations/services/account.service'

export default {
  name: 'transaction-validator',
  data() {
    return {
      inputId: '',
      message: '',
      data: null
    }
  },
  methods: {
    async execute() {
      try {
        const tx = await TransactionService.fetchById(this.inputId)

        if (tx.status === 'success') {
          this.message = this.$t('alreadyProcessed')
          this.data = null
        } else {
          await TransactionService.updateStatus(tx.id, 'success')

          const accounts = await AccountService.fetchAll()
          const account = accounts.find(a => a.id === tx.accountId)

          this.data = { ...tx, ...account }
          this.message = ''
        }
      } catch {
        this.message = this.$t('invalidTransactionId')
        this.data = null
      }
    }
  }
}
</script>

<style scoped>
.transaction-validator-container {
  padding: 1rem;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  color: #2c3e50;
}

.transaction-validator-title {
  font-size: 1.25rem;
  font-weight: 600;
  margin-bottom: 0.5rem;
}

.transaction-validator-input-wrapper {
  margin-bottom: 0.5rem;
  max-width: 320px;
}

.transaction-validator-input {
  width: 100%;
  padding: 0.5rem;
  font-size: 1rem;
  border: 1px solid #ccc;
  border-radius: 6px;
  box-sizing: border-box;
  transition: border-color 0.3s ease;
}

.transaction-validator-input:focus {
  border-color: #3182ce;
  outline: none;
  box-shadow: 0 0 0 2px rgba(49, 130, 206, 0.3);
}

.transaction-validator-button {
  background-color: #3182ce;
  color: white;
  border: none;
  padding: 0.5rem 1rem;
  font-weight: 600;
  border-radius: 6px;
  cursor: pointer;
  display: inline-flex;
  align-items: center;
  gap: 0.5rem;
  transition: background-color 0.3s ease;
}

.transaction-validator-button:hover {
  background-color: #2c5282;
  transition: background-color 0.3s ease;
}

.transaction-validator-message {
  color: #e53e3e; /* rojo para errores */
  margin-top: 0.5rem;
}

.transaction-validator-data {
  margin-top: 1rem;
  border: 1px solid #ddd;
  background-color: #f7fafc;
  padding: 1rem;
  border-radius: 8px;
  box-shadow: 0 1px 4px rgba(0, 0, 0, 0.1);
}

.transaction-validator-data p {
  margin: 0.3rem 0;
  font-size: 1rem;
}

.transaction-validator-data strong {
  color: #2c3e50;
}
</style>