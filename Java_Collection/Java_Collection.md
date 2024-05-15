# Java Collection
Dalam bahasa pemrograman (termasuk java), collection (atau biasa disebut container) adalah object yang mengumpulkan atau berisikan data-data, serupa dengan Array. Java sudah menyediakan class collection dimana semuanya bersifat generic class.


## A. Fungsi Koleksi
### Iterasi
 Collection memungkinkan iterasi (pengulangan) elemen menggunakan iterator. Hal ini memungkinkan pengolahan setiap elemen dalam koleksi. 
 ### Penambahan dan Penghapusan
Collection memungkinkan untuk menambah dan menghapus elemen dengan mudah. Misalnya, metode *add()* untuk menambah elemen dan *remove()* untuk menghapus elemen.
### Mengelola elemen
Collection menyediakan metode untuk memeriksa apakah elemen tertentu ada *(contains())*, mendapatkan elemen *(get())*, atau mengubah elemen.

## B. Jenis-jenis Collection
### List
Menyimpan elemen dalam urutan tertentu dan memungkinkan duplikasi. Setiap elemen memiliki indeks.

1. ArrayList: Menyediakan akses cepat ke elemen, cocok untuk operasi pencarian.
2. LinkedList: Cocok untuk operasi penambahan dan penghapusan elemen karena menggunakan struktur linked list.

### Queue
Mengikuti prinsip FIFO (First-In-First-Out), cocok untuk antrian tugas.

1. PriorityQueue: Mengurutkan elemen berdasarkan urutan alami atau comparator yang diberikan.
2. LinkedList: Selain sebagai List, juga bisa digunakan sebagai Queue, memungkinkan penambahan dan penghapusan dari kedua ujung.

### Deque
Singkatan dari "double-ended queue", memungkinkan penambahan dan penghapusan elemen dari kedua ujung. Cocok untuk implementasi stack dan queue.

1. ArrayDeque: Implementasi berbasis array yang menyediakan operasi konstan waktu untuk penambahan dan penghapusan elemen di kedua ujung.
2. LinkedList: Selain sebagai List dan Queue, juga mendukung operasi Deque, memungkinkan fleksibilitas dalam manipulasi elemen dari kedua ujung.

### Map
Memetakan kunci unik ke nilai tertentu. Setiap kunci hanya boleh muncul sekali.
1. HashMap: Menggunakan hash table untuk menyimpan pasangan kunci-nilai, efisien untuk pencarian berdasarkan kunci.

## Contoh Implementasi
Untuk menggunakan koleksi, perlu dibuat objek dari class collection.

```java

// Membuat objek List
// Digunakan untuk menyimpan daftar nama
List<String> list = new ArrayList<>();
list.add("Agus");
list.add("Amin");
list.add("Ahmad");

// Membuat objek Map
// Digunakan untuk menyimpan pasangan kunci-nilai hewan dan jumlahnya
Map<String, Integer> map = new HashMap<>();
map.put("Ayam", 1);
map.put("Bebek", 2);
map.put("Angsa", 3);

// Membuat objek Deque
// Digunakan mendemostrasikan bahwa deque dapat menambahkan emelen di awal dan akhir
Deque<String> deque = new ArrayDeque<>();
deque.addFirst("Rizqi");
deque.addLast("Aditya");
deque.addFirst("Firmansyah");
```

