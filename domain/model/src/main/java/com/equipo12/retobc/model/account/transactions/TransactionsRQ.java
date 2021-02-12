package com.equipo12.retobc.model.account.transactions;

import com.equipo12.retobc.model.account.AccountRQ;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class TransactionsRQ {
   private Pagination pagination;
   private AccountRQ account;
   private TransactionRQ transaction;
   private OfficeRQ office;
}
