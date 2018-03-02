package com.example.bellatrix.interview.ricardo.ui;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class SearchResultsPage {

	public static Target TOTAL_SEARCH_RESULTS = Target.the("total search results").located(By.className("rsHdr"));
	public static Target FILTER = Target.the("a filter").locatedBy("[aria-label='{0}']");
	public static Target FILTERS_APPLIED = Target.the("Filters applied").located(By.className("cons"));
	public static Target FILTER_APPLIED_FIELD = Target.the("a filter applied").locatedBy(".cons [data-value='{0}']");
	public static Target SORT_FIELD = Target.the("Options for sort results")
			.located(By.id("DashSortByContainer"));
	public static Target SORTED_OPTION = Target.the("sort option").locatedBy("#DashSortByContainer [value='{0}']");
	public static Target VIEW_TYPE = Target.the("Customize results view").located(By.id("viewType"));
	public static Target CUSTOMIZE_LINK = Target.the("Customize link to Form").located(By.id("custLink"));
	public static Target CONVERT_PRICES = Target.the("Convert Prices to local currency option")
			.locatedBy("[name='_fcpd']");
	public static Target SAVE_CHANGES = Target.the("Save custom view changes")
			.locatedBy("[name='customizationForm'] [type='submit']");
	public static Target PRODUCTS_LIST = Target.the("List of search products result")
			.locatedBy("#ListViewInner .lvresult");
}
