Feature: Product Search and Filtering  

Background:  
  Given The user is on the homepage  
  When The user searches for "Computer" using the search bar  
  And Clicks the "Search" button  
  Then The user should see relevant product results  

Scenario: Filter products by price (Low to High)  
  When The user sorts the products by price from low to high  
  Then The displayed products should be sorted accordingly  

Scenario: Filter products alphabetically (A to Z)  
  When The user sorts the products alphabetically from A to Z  
  Then The displayed products should appear in alphabetical order  
