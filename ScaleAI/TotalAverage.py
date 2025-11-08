from collections import defaultdict

def calculate_user_currency_summary(transactions):
    """
    Computes total and average spend per user per currency.
    Handles negative (refund) values and invalid entries.
    """

    def is_valid(record):
        """Check for valid user, numeric amount, and valid currency."""
        return (
            record.get("user")
            and record.get("currency")
            and isinstance(record.get("amount"), (int, float))
        )

    # Nested defaultdict: user → currency → list of amounts
    grouped = defaultdict(lambda: defaultdict(list))

    for record in transactions:
        if not is_valid(record):
            continue
        user = record["user"]
        curr = record["currency"]
        amt = record["amount"]
        grouped[user][curr].append(amt)

    # Compute total and average per user per currency
    summary = {}
    for user, currencies in grouped.items():
        summary[user] = {}
        for curr, amounts in currencies.items():
            total = sum(amounts)
            avg = total / len(amounts)
            summary[user][curr] = {"total": total, "avg": avg}
    return summary


# Example usage
transactions = [
    {"user": "Alice", "amount": 120, "currency": "USD"},
    {"user": "Alice", "amount": -20, "currency": "USD"},
    {"user": "Bob", "amount": 100, "currency": "EUR"},
    {"user": "Alice", "amount": 50, "currency": "EUR"},
    {"user": "Charlie", "amount": 200, "currency": "USD"},
    {"user": None, "amount": 70, "currency": "USD"},
]

result = calculate_user_currency_summary(transactions)
print(result)











# from collections import defaultdict
# transactions = [
#     {"user": "Alice", "currency" :"USD", "amount": 120},
#     {"user": "Bob", "amount": 90},
#     {"user": "Alice", "amount": 80},
#     {"user": "Charlie", "amount": 100},
#     {"user": "Bob", "amount": 60},
# ]

# def get_transaction_summary(transactions):
#         d = defaultdict(lambda: defaultdict(list))
#         for tx in transactions:
#             user = tx.get("user")
#             curr = tx.get("currency")
#             amount = tx.get("amount")
#             d[user][curr].append(amount)
#         print(d)
#         summary = {}
#         for user,amount in d.items():
#             total = sum(amount)
#             avg = total/len(amount)

#             summary[user]={"total":total,"average":avg}
#         return summary
# result = get_transaction_summary(transactions)
# print(result)
