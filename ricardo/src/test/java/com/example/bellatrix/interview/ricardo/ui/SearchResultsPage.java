package com.example.bellatrix.interview.ricardo.ui;

import org.openqa.selenium.By;

import net.serenitybdd.screenplay.targets.Target;

public class SearchResultsPage {

	public static Target TOTAL_SEARCH_RESULTS = Target.the("total search results").located(By.className("rsHdr"));
	public static Target FILTER = Target.the("a filter").locatedBy("[aria-label='{0}']");
	public static Target FILTERS_APPLIED = Target.the("Filters applied").located(By.className("cons"));
	public static Target FILTER_APPLIED_FIELD = Target.the("a filter applied").locatedBy(".cons [data-value='{0}']");
	public static Target SORT_FIELD = Target.the("Dropdown menu for sting options")
			.located(By.id("DashSortByContainer"));
	public static Target SORTED_OPTION = Target.the("sort option").locatedBy("#DashSortByContainer [value='{0}']");
}
