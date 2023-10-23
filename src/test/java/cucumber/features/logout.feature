Feature: User logout aplikasi

  Scenario: User logout aplikasi
    Given User sudah login aplikasi
    When User klik tombol logout
    Then User berhasil logout
    And User melihat menu login