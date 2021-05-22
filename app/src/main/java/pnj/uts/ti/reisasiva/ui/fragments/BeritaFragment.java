package pnj.uts.ti.reisasiva.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import pnj.uts.ti.reisasiva.R;
import pnj.uts.ti.reisasiva.adapter.BeritaListViewAdapter;
import pnj.uts.ti.reisasiva.model.Berita;
import pnj.uts.ti.reisasiva.ui.activities.DetailBeritaActivity;

import java.util.ArrayList;

public class BeritaFragment extends Fragment {

    private BeritaListViewAdapter beritaAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_berita, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView listView = view.findViewById(R.id.listViewBerita);
        beritaAdapter = new BeritaListViewAdapter(getContext());
        listView.setAdapter(beritaAdapter);

        addItem();

        listView.setOnItemClickListener((parent, view1, position, id) -> {
            Berita berita = (Berita) parent.getAdapter().getItem(position);
            Intent intent = new Intent(getActivity(), DetailBeritaActivity.class);
            intent.putExtra("image", berita.getImage());
            intent.putExtra("judul", berita.getJudul());
            intent.putExtra("deskripsi", berita.getDeskripsi());
            startActivity(intent);
        });
    }

    private void addItem() {
        String[] beritaDeskripsi = new String[]{
                "Lomba poster dan video merupakan salah satu rangkaian dari Campaign, Webinar, Workshop Earth Day Unpad 2021. Lomba poster dan video tahun ini mengusung tema “Common Action to Prevent Climate Change.",
                "Geopoint 2021 merupakan rangkaian acara yang diselenggarakan secara online untuk mengenalkan dan memaksimalkan manfaat keilmuan Geodesi dan Geomatika kepada masyarakat umum yang terdiri dari Geospatial Challenge, Webinar and Virtual Exhibition, Geodesy Goes to School, Navigacity, Opening and Closing Ceremony.",
                "Mechanical Design Competition (MEDCOM) adalah acara yang diadakan setiap tahun oleh Keluarga Mahasiswa Teknik Mesin UGM, dan tahun ini MEDCOM 2020 menjadi salah satu rangkaian acara dalam Dies Natalis ke-61 Teknik Mesin UGM.",
                "AnthroCreative merupakan kegiatan perlombaan siswa/i SMA/sederajat yang terdiri dari dua program, yakni Lomba Fotografi dan Sayembara Desain Merchandise yang akan mengangkat tema “kebudayaan” yang juga dikaitkan dengan fenomena “pandemi Covid-19” di Indonesia, untuk ikut mensosialisasikan kepada masyarakat tentang pentingnya protokol kesehatan pada masa pandemi Covid-19.",
                "Himpunan Mahasiswa Jurusan Sejarah Peradaban Islam UIN Sunan Ampel Surabaya mempersembahkan Festival Sejarah 2020 dalam rangka memeriahkan Dies Natalis Jurusan Sejarah Peradaban Islam yang ke-45.",
                "Berlin - Menteri Luar Negeri Jerman, Heiko Maas akan melakukan perjalanan ke Israel dan Palestina pada Kamis waktu setempat. Kunjungan itu akan digunakan untuk melakukan pembicaraan mengenai konflik yang terjadi di Gaza. \"Pembicaraan politik akan fokus pada eskalasi saat ini di Timur Tengah dan upaya internasional untuk mengakhiri kekerasan,\" kata Juru Bicara Kementerian Luar Negeri Jerman, seperti dilansir AFP, Rabu (19/5/2021). Maas akan bertemu dengan menteri luar negeri dan pertahanan Israel serta Presiden Reuven Rivlin. Dia juga akan melakukan perjalanan ke kota Ramallah untuk mengadakan pembicaraan dengan Perdana Menteri Palestina.",
                "Menteri Pendidikan, Kebudayaan, Riset dan Teknologi (Mendikbudristek) Nadiem Makarim mengapresiasi 4 tim asal Indonesia yang berhasil menang dalam kompetisi Shell Eco-Marathon (SEM) Off-Track_ 2021. Ajang tersebut merupakan inovasi kendaraan hemat energi tingkat internasional.",
                "Pusat Prestasi Nasional (Puspresnas), Kemendikbud Ristek kembali menyelenggarakan kegiatan Pagelaran Mahasiswa Nasional Bidang Teknologi, Informasi, dan Komunikasi (GEMASTIK). Pendaftaran akan dibuka bulan Juni 2021 mendatang.",
                "Pusat Prestasi Nasional (Pusprenas) Kementerian Pendidikan, Kebudayaan, Riset, dan Teknologi (Kemdikbudristek) mengadakan Kompetisi Nasional Matematika dan Ilmu Pengetahuan Alam Perguruan Tinggi (KNMIPA-PT) untuk mahasiswa se-Indonesia. Pemenangnya bisa berkesempatan ikutan lomba ke Bulgaria.",
                "Pusat Prestasi Nasional, Sekretariat Jenderal, Kementerian Pendidikan dan Kebudayaan telah membuka registrasi untuk pendaftaran Kompetisi Sains Nasional tingkat Kabupaten/ Kota (KSN-K) untuk siswa SMA MA."

        };

        String[] beritaJudul = new String[]{
                "Earth Day Unpad 2021 : Poster And Video Competition",
                "Geopoint ITB 2021",
                "Mechanical Design Competition (MEDCOM) 2020 – UGM",
                "Lomba Fotografi Dan Desain Merchandise “AnthroCreative”",
                "Festival Sejarah 2020 – UIN Sunan Ampel Surabaya",
                "Management Competition In Tourism – Universitas Sanata Dharma",
                "4 Tim Asal RI Menang di Ajang Inovasi Kendaraan Internasional, Nadiem Makarim: Membanggakan!",
                "Pendaftaran Lomba TIK GEMASTIK 2021 Segera Dibuka, Siapkan Tim Terbaikmu!",
                "Ikutan Kompetisi Nasional Matematika dan IPA Yuk, Pemenang Bisa Lomba ke Bulgaria!",
                "Ada Kompetisi Sains Nasional untuk Siswa SMA, Yuk Daftar Lewat Sekolah!"

        };

        String[] beritaImage = new String[]{
                "https://haievent.com/wp-content/uploads/2021/04/Earth-Day-Unpad-2021-Poster-and-Video-Competition-576x1024.jpg?w=700&q=90",
                "https://haievent.com/wp-content/uploads/2020/09/Geopoint-ITB-2021.jpg",
                "https://haievent.com/wp-content/uploads/2020/09/Mechanical-Design-Competition-MEDCOM-2020-UGM.jpg",
                "https://haievent.com/wp-content/uploads/2020/08/flyer-anthrocreative-1-723x1024.jpg",
                "https://haievent.com/wp-content/uploads/2020/08/Festival-Sejarah-2020-UIN-Sunan-Ampel-Surabaya-819x1024.jpg?w=700&q=90",
                "https://.haievent.com/wp-content/uploads/2020/08/Management-Competition-in-Tourism-Universitas-Sanata-Dharma.jpeg",
                "https://akcdn.detik.net.id/community/media/visual/2020/06/16/nadiem-makarim_43.jpeg?w=700&q=90",
                "https://akcdn.detik.net.id/community/media/visual/2019/06/17/772710cf-6870-4b5e-b124-375f0786eb18_43.jpeg?w=700&q=90",
                "https://akcdn.detik.net.id/community/media/visual/2019/09/05/511ae94c-9a66-44b9-acdb-e74c9cfe6181_43.jpeg?w=700&q=90",
                "https://akcdn.detik.net.id/community/media/visual/2021/01/04/hari-pertama-masuk-sekolah-di-tengah-pandemi-covid-19_43.jpeg?w=700&q=90"
        };

        ArrayList<Berita> news = new ArrayList<>();
        for (int i = 0; i < beritaJudul.length; i++) {
            Berita berita = new Berita();
            berita.setImage(beritaImage[i]);
            berita.setJudul(beritaJudul[i]);
            berita.setDeskripsi(beritaDeskripsi[i]);
            news.add(berita);
        }

        beritaAdapter.setNews(news);
    }
}