Feature: User menambahkan produk kedalam keranjang

  Scenario: User tambah produk ke keranjang
    Given User berada di halaman produk
    When User klik tombol add to cart
    And User berhasil menambahkan produk
    Then User klik icon keranjang
    And User melihat menu keranjang