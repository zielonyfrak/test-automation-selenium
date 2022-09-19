package com.bartekmarek.driver;

import com.bartekmarek.page.base.PageGenerator;

public class PageManager {
    private static final ThreadLocal<PageManager> INSTANCE = ThreadLocal.withInitial(PageManager::new);
    private PageGenerator pageGenerator;

    public static synchronized PageManager getInstance(){
        return INSTANCE.get();
    }

    public static synchronized void cleanUp(){
        INSTANCE.remove();
    }

    public void closeDriver() {
        pageGenerator.driver.quit();
    }

    public void initialisePageGenerator() {
        pageGenerator = new PageGenerator(new DriverSupplier().getDriver());
    }

    public PageGenerator getPageGenerator(){
        return pageGenerator;
    }
}
