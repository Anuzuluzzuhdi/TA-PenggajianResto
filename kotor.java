// ...

static void menuUtama() {
    while (true) {
        System.out.println("===================================");
        System.out.println("\nSelamat datang di Aplikasi Penggajian.");
        String[] sistem;

        // Menentukan opsi menu berdasarkan jenis manager yang login
        if (user[0][0].equals("manager1")) {
            sistem = new String[]{"Backoffice"};
        } else if (user[1][0].equals("manager2")) {
            sistem = new String[]{"Operasional"};
        } else {
            // Default jika ada manager baru
            sistem = new String[]{"Penggajian", "Data karyawan", "Laporan Bulanan"};
        }

        int inputSistem;

        System.out.println("\n|===================================|");
        System.out.println("|      Ingin masuk ke sistem apa?   |");
        System.out.println("|===================================|");

        // Menampilkan opsi menu sesuai dengan jenis manager
        for (int i = 0; i < sistem.length; i++) {
            System.out.println("|          " + (i + 1) + ". " + sistem[i] + "         |");
        }

        System.out.println("|===================================|");
        System.out.print("\nMasukkan sistem yang ingin anda masuki: ");
        inputSistem = scsistem.nextInt();

        switch (inputSistem) {
            case 1:
                if (user[0][0].equals("manager1")) {
                    menuBackoffice();
                } else if (user[1][0].equals("manager2")) {
                    menuOperasional();
                }
                break;
            case 2:
                menuDataKaryawan();
                break;
            case 3:
                laporanBulanan();
                break;
            default:
                System.out.println("Inputan tidak valid. Silakan ");
                break;
        }
    }
}

static void menuBackoffice() {
    // Implementasi menu untuk backoffice
    // ...
}

static void menuOperasional() {
    // Implementasi menu untuk operasional
    // ...
}

static void prosesPenggajian() {
    System.out.println("\n===========Penggajian Karyawan==========");
    System.out.print("Masukkan id karyawan yang ingin digaji: ");
    String idkaryawan = scidbuatgaji.nextLine();

    boolean found = false;
    for (int i = 0; i < currentIndex; i++) {
        String[] karyawan = dataKaryawan1[i];

        // Menentukan jenis manager yang login
        String jenisManager = "";
        if (user[0][0].equals("manager1")) {
            jenisManager = "Backoffice";
        } else if (user[1][0].equals("manager2")) {
            jenisManager = "Operasional";
        }

        // Mengecek apakah karyawan sesuai dengan jenis manager yang login
        if (karyawan[1].equalsIgnoreCase(jenisManager) && karyawan[0].equals(idkaryawan)) {
            // Proses penggajian sesuai dengan jenis manager
            // ...
            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("Karyawan dengan ID " + idkaryawan + " tidak ditemukan atau tidak sesuai dengan jenis manager.");
    }
}

// ...
