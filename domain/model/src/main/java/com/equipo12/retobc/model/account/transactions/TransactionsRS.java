package com.equipo12.retobc.model.account.transactions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class TransactionsRS {
   private String responseSize;
   private Boolean flagMoreRecords;
   private List<TransactionRS> transactionRS;
   private OfficeRS office;
   private Customer customer;
   private RelatedTransferAccount relatedTransferAccount;

}
