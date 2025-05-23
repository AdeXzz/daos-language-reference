export class Transaction {
    constructor(id, accountId, transactionType, amount, executedAt, status) {
        this.id = id
        this.accountId = accountId
        this.transactionType = transactionType
        this.amount = amount
        this.executedAt = executedAt
        this.status = status
    }
}