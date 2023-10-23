Feature: User login aplikasi

  Scenario: User login aplikasi menggunakan credential yang valid
    Given User masuk ke alamat aplikasi
    When User input username yang sesuai
    And User input password yang sesuai
    And User klik tombol Login
    Then User melihat menu produk

  Scenario: User login aplikasi menggunakan credential yang tidak valid
    Given User masuk ke alamat aplikasi
    When User input username yang sesuai
    And User input password yang tidak sesuai
    And User klik tombol Login
    Then User melihat error

