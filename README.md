# Bank Statement Analyzer

Bank Statement Analyzer take in your bank statement as an input and analyze it.

The bank statement has to be a _csv_ file, and formatted like this example:

```
30-01-2017,-100,Deliveroo
30-01-2017,-50,Tesco
01-02-2017,6000,Salary
02-02-2017,2000,Royalties
02-02-2017,-4000,Rent
03-02-2017,3000,Tesco
05-02-2017,-30,Cinema
```

Bank Statement Analyzer will analyze the following information:
1. Total profit and loss
2. Number of transactions
3. Top-10 expenses
4. Category with the highest spending