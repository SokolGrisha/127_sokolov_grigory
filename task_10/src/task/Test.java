package task;

import org.junit.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static task.TypeDoc.*;

public class Test extends Assert {

    @org.junit.Test
    public void create_CreateListOfContracts_ContractsCountEqualsZero() throws Exception {
        MangerOfDeals MangerOfDeals = new MangerOfDeals();
        assertEquals(0, MangerOfDeals.getDealsCount());
    }

    @org.junit.Test
    public void create_deal_create_dealWithNumberAndDate_ContractsCountEqualsOne() throws Exception {
        MangerOfDeals MangerOfDeals = new MangerOfDeals();
        MangerOfDeals.create_deal("20211218", "1");
        assertEquals(1, MangerOfDeals.getDealsCount());
    }

    @org.junit.Test
    public void create_deal_create_dealsWithNumberAndDate_ContractsCountEqualsThree() throws Exception {
        MangerOfDeals MangerOfDeals = new MangerOfDeals();
        MangerOfDeals.create_deal("20211218", "1");
        MangerOfDeals.create_deal("20211218", "2");
        MangerOfDeals.create_deal("20211218", "3");
        assertEquals(3, MangerOfDeals.getDealsCount());
    }

    @org.junit.Test
    public void create_deal_create_dealsWithNumberAndDate_PaymentDocumentCountEqualsZero() throws Exception {
        MangerOfDeals MangerOfDeals = new MangerOfDeals();
        MangerOfDeals.create_deal("20211218", "1");
        assertEquals(0, MangerOfDeals.getDeals().get("1").list_of_docs().size());
    }

    @org.junit.Test
    public void create_pay_doc_create_pay_docWithData_DocumentsCountEqualsOne() throws Exception {
        MangerOfDeals MangerOfDeals = new MangerOfDeals();
        MangerOfDeals.create_deal("20211218", "1");
        MangerOfDeals.create_pay_doc("1",1000, 1,"20220111", PaymentsDoc);
        assertEquals(1, MangerOfDeals.getDeals().get("1").list_of_docs().size());
    }

    @org.junit.Test
    public void create_pay_doc_create_pay_docWithData_DocumentsCountEquals6000() throws Exception {
        MangerOfDeals MangerOfDeals = new MangerOfDeals();
        MangerOfDeals.create_deal("20211218", "1");
        MangerOfDeals.create_pay_doc("1",2000, 1,"20220111", PaymentsDoc);
        MangerOfDeals.create_pay_doc("1",2000, 2,"20220111", PaymentsDoc);
        MangerOfDeals.create_pay_doc("1",2000, 3,"20220111", PaymentsDoc);
        assertEquals(3, MangerOfDeals.getDeals().get("1").list_of_docs().size());
    }

    @org.junit.Test
    public void getAmount_CalculateContractAmountOfPayments_AmountEquals5000() throws Exception {
        MangerOfDeals MangerOfDeals = new MangerOfDeals();
        MangerOfDeals.create_deal("20211218", "1");
        MangerOfDeals.create_pay_doc("1",1000, 1,"20220111", PaymentsDoc);
        MangerOfDeals.create_pay_doc("1",2000, 2,"20220111", PaymentsDoc);
        MangerOfDeals.create_pay_doc("1",2000, 3,"20220111", PaymentsDoc);
        assertEquals(5000, MangerOfDeals.getDeals().get("1").getSum());
    }

    @org.junit.Test
    public void delete_doc_delete_PaymentsCountEqualsTwo() throws Exception {
        MangerOfDeals MangerOfDeals = new MangerOfDeals();
        MangerOfDeals.create_deal("20211218", "1");
        MangerOfDeals.create_pay_doc("1",1000, 1,"20220111", PaymentsDoc);
        MangerOfDeals.create_pay_doc("1",2000, 2,"20220111", PaymentsDoc);
        MangerOfDeals.create_pay_doc("1",2000, 3,"20220111", PaymentsDoc);
        MangerOfDeals.delete_doc("1",1,"20220111");
        assertEquals(2, MangerOfDeals.getDeals().get("1").list_of_docs().size());
    }

    @org.junit.Test
    public void delete_doc_delete_PaymentsCountEqualsZero() throws Exception {
        MangerOfDeals MangerOfDeals = new MangerOfDeals();
        MangerOfDeals.create_deal("20211218", "1");
        MangerOfDeals.create_pay_doc("1",1000, 1,"20220111", PaymentsDoc);
        MangerOfDeals.create_pay_doc("1",2000, 2,"20220111", PaymentsDoc);
        MangerOfDeals.create_pay_doc("1",3000, 3,"20220111", PaymentsDoc);
        MangerOfDeals.delete_doc("1", 1,"20220111");
        MangerOfDeals.delete_doc("1", 2,"20220111");
        MangerOfDeals.delete_doc("1", 3,"20220111");
        assertEquals(0, MangerOfDeals.getDeals().get("1").list_of_docs().size());
    }

    @org.junit.Test
    public void getList_GetListOfAllPayments_ListEqualsTestList() throws Exception {
        MangerOfDeals MangerOfDeals = new MangerOfDeals();
        MangerOfDeals.create_deal("20211218", "1");
        MangerOfDeals.create_pay_doc("1",1000, 1,"20220111", PaymentsDoc);
        MangerOfDeals.create_pay_doc("1",2000, 2,"20220111", PaymentsDoc);
        MangerOfDeals.create_pay_doc("1",2000, 3,"20220111", PaymentsDoc);
        MangerOfDeals.create_deal("20211219", "2");
        MangerOfDeals.create_pay_doc("2",1000, 1,"20220111", PaymentsDoc);
        MangerOfDeals.create_pay_doc("2",2000, 2,"20220111", PaymentsDoc);
        MangerOfDeals.create_pay_doc("2",3000, 3,"20220111", PaymentsDoc);

        List<Integer> payments = new ArrayList();
        payments.add(100);
        payments.add(200);
        payments.add(300);
        payments.add(311);
        payments.add(211);
        payments.add(111);

        assertArrayEquals(payments.toArray(),MangerOfDeals.list_of_all_docs().toArray());
    }

    @org.junit.Test
    public void getPayments_GetAllPaymentsFromContract_ListEqualsTestList() throws Exception {
        MangerOfDeals MangerOfDeals = new MangerOfDeals();
        MangerOfDeals.create_deal("20211218", "1");
        MangerOfDeals.create_pay_doc("1",1000, 1,"20220111", PaymentsDoc);
        MangerOfDeals.create_pay_doc("1",2000, 2,"20220111", PaymentsDoc);
        MangerOfDeals.create_pay_doc("1",2000, 3,"20220111", PaymentsDoc);
        MangerOfDeals.create_deal("20211219", "2");
        MangerOfDeals.create_pay_doc("2",1000, 1,"20220111", PaymentsDoc);
        MangerOfDeals.create_pay_doc("2",2000, 2,"20220111", PaymentsDoc);
        MangerOfDeals.create_pay_doc("2",3000, 3,"20220111", PaymentsDoc);

        List<Integer> payments = new ArrayList();
        payments.add(100);
        payments.add(200);
        payments.add(300);

        assertArrayEquals(payments.toArray(),MangerOfDeals.getDeals().get("1").list_of_docs().toArray());
    }

    @org.junit.Test
    public void getMap_GetMapOfContractsWithSumOfPayments_MapEqualsTestMap() throws Exception {
        MangerOfDeals MangerOfDeals = new MangerOfDeals();
        MangerOfDeals.create_deal("20211218", "1");
        MangerOfDeals.create_pay_doc("1",1000, 1,"20220111", PaymentsDoc);
        MangerOfDeals.create_pay_doc("1",2000, 2,"20220111", PaymentsDoc);
        MangerOfDeals.create_pay_doc("1",2000, 3,"20220111", PaymentsDoc);
        MangerOfDeals.create_deal("20211219", "2");
        MangerOfDeals.create_pay_doc("2",1001, 1,"20220111", PaymentsDoc);
        MangerOfDeals.create_pay_doc("2",2002, 2,"20220111", PaymentsDoc);
        MangerOfDeals.create_pay_doc("2",3003, 3,"20220111", PaymentsDoc);

        List<String> contractsTest = new ArrayList();
        List<Integer> paymentsTest = new ArrayList();
        contractsTest.add("1");
        paymentsTest.add(5000);
        contractsTest.add("2");
        paymentsTest.add(5005);

        HashMap<String,Integer> contractsWithPayments = MangerOfDeals.deals_and_paymonts();
        List<String> contracts = new ArrayList();
        List<Integer> payments = new ArrayList();

        for (Map.Entry<String, Integer> entry: contractsWithPayments.entrySet()){
            contracts.add(entry.getKey());
            payments.add(entry.getValue());
        }

        assertArrayEquals(contractsTest.toArray(), contracts.toArray());
        assertArrayEquals(paymentsTest.toArray(), payments.toArray());
    }

}
