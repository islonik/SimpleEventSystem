package org.nikilipa.ses.sim.services;

import org.nikilipa.ses.sim.db.FinanceDao;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by nikilipa on 7/25/16.
 */
public class FinanceServiceTest {

    @Test
    public void testIsEnoughMoney() {
        FinanceDao financeDao = Mockito.mock(FinanceDao.class);
        FinanceService financeService = new FinanceService();
        financeService.setDao(financeDao);

        /*String financeCode = FinanceDao.FINANCE_CODE_MIGRATION;

        int days1 = 40;
        int days2 = 60;
        Assert.assertTrue(financeService.isEnoughMoney(financeCode, days1));
        Assert.assertTrue(financeService.updateFinance(financeCode, days1));
        Assert.assertTrue(financeService.isEnoughMoney(financeCode, days2));
        Assert.assertTrue(financeService.updateFinance(financeCode, days2));

        int days3 = 80;
        int days4 = 20;
        Assert.assertTrue(financeService.isEnoughMoney(financeCode, days3));
        Assert.assertTrue(financeService.updateFinance(financeCode, days3));
        Assert.assertTrue(financeService.isEnoughMoney(financeCode, days4));
        Assert.assertTrue(financeService.updateFinance(financeCode, days4));

        int days5 = 50;
        Assert.assertTrue(financeService.isEnoughMoney(financeCode, days5));
        Assert.assertTrue(financeService.updateFinance(financeCode, days5));
        Assert.assertTrue(financeService.isEnoughMoney(financeCode, days5));
        Assert.assertTrue(financeService.updateFinance(financeCode, days5));

        int days6 = 30;
        int days7 = 70;
        Assert.assertTrue(financeService.isEnoughMoney(financeCode, days6));
        Assert.assertTrue(financeService.updateFinance(financeCode, days6));
        Assert.assertTrue(financeService.isEnoughMoney(financeCode, days7));
        Assert.assertTrue(financeService.updateFinance(financeCode, days7));

        int days8 = 10;
        int days9 = 85;
        Assert.assertTrue(financeService.isEnoughMoney(financeCode, days8));
        Assert.assertTrue(financeService.updateFinance(financeCode, days8));
        Assert.assertTrue(financeService.isEnoughMoney(financeCode, days9));
        Assert.assertTrue(financeService.updateFinance(financeCode, days9));

        int days10 = 5;
        Assert.assertFalse(financeService.isEnoughMoney(financeCode, days8));
        Assert.assertFalse(financeService.updateFinance(financeCode, days8));
        Assert.assertTrue(financeService.isEnoughMoney(financeCode, days10));
        Assert.assertTrue(financeService.updateFinance(financeCode, days10));*/
    }
}
