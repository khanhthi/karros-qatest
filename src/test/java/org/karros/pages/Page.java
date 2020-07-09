package org.karros.pages;

import org.openqa.selenium.WebDriver;

import java.io.IOException;

import org.karros.TestNgTestBase;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class Page {

  protected WebDriver driver;

  /*
   * Constructor injecting the WebDriver interface
   * 
   * @param webDriver
   */
  public Page(WebDriver driver) throws IOException {
    this.driver = driver;
  }

  public String getTitle() {
    return driver.getTitle();
  }

}
