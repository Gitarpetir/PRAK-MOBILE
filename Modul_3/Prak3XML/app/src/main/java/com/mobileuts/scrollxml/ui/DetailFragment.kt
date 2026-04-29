package com.mobileuts.scrollxml.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mobileuts.scrollxml.R
import com.mobileuts.scrollxml.databinding.FragmentDetailBinding
import com.mobileuts.scrollxml.model.Friend

class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val friendId = arguments?.getInt("friendId")
        val friendList = getDummyFriends()
        val selectedFriend = friendList.find { it.id == friendId }

        if (selectedFriend != null) {
            binding.ivDetailImage.setImageResource(selectedFriend.imageResId)
            binding.tvDetailName.text = selectedFriend.name
            binding.tvDetailDate.text = selectedFriend.date
            binding.tvDetailDescription.text = selectedFriend.description
        }

        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getDummyFriends(): List<Friend> {
        return listOf(
            Friend(
                id = 1,
                name = "Luthfi Sang Pencinta Wanita",
                date = "Dilan 1988",
                description = "Aku memang pencinta wanita namun ku bukan buaya, yang setia pada seribu gadis, ku hanya mencintai dia.",
                imageResId = R.drawable.luthfi,
                instagramUrl = "https://www.instagram.com/aluthfi_m?igsh=cWtwd3p6YmpsdjZh"
            ),
            Friend(
                id = 2,
                name = "Andre Mukbang Semangka",
                date = "RBTI 2026",
                description = "Andre sedang memakan potongan 3/4 semangkah agar tubuhnya kuat",
                imageResId = R.drawable.andre,
                instagramUrl = "https://www.instagram.com/andrecrnth?igsh=MWozZWRqbWlkZG02Yg=="
            ),
            Friend(
                id = 3,
                name = "Azriel Akbar",
                date = "32 Desember",
                description = "Azriel membajak hp ku dan memfoto muhanya",
                imageResId = R.drawable.azriel,
                instagramUrl = "https://www.instagram.com/akbzrl?igsh=MWJsMGw0dThmNmE3bA=="
            ),
            Friend(
                id = 4,
                name = "Faqih",
                date = "Kada Ingat",
                description = "Faqih ketika diajak main ps",
                imageResId = R.drawable.faqih,
                instagramUrl = "https://www.instagram.com/faqihazma?igsh=MWd2NDB3bXQ3Zm5kMw=="
            ),
            Friend(
                id = 5,
                name = "Gezoy Kahim",
                date = "30 Februari",
                description = "Ghazi melet kada tahu gasan apa",
                imageResId = R.drawable.ghazi,
                instagramUrl = "https://www.instagram.com/muh.ghazii?igsh=eWxqazRiNTlmOW9s"
            ),
            Friend(
                id = 6,
                name = "Numerikafka",
                date = "Intinya E2C",
                description = "Foto bukti mengikuti E2C",
                imageResId = R.drawable.maul,
                instagramUrl = "https://www.instagram.com/maulanazhaari?igsh=MWY4czM2Y2NmaW1iMQ=="
            ),
            Friend(
                id = 7,
                name = "Veast.",
                date = "Matkul Bu Mute",
                description = "Nafis pas masih maba baru",
                imageResId = R.drawable.nafis,
                instagramUrl = "https://www.instagram.com/nfisp?igsh=MWN6OW1ocndpNHVkNw=="
            ),
            Friend(
                id = 8,
                name = "Rakhatuy Athaluy",
                date = "Kada Ingat",
                description = "Ganti gaya rambut agar wanita kepincut",
                imageResId = R.drawable.rakha,
                instagramUrl = "https://www.instagram.com/raakhatha?igsh=MTg0bXhzdjhteGlrNw=="
            ),
            Friend(
                id = 9,
                name = "Luckyboyy",
                date = "Claude 2012",
                description = "Blazing Duet From LUCKYBOYYY",
                imageResId = R.drawable.ulyani,
                instagramUrl = "https://www.instagram.com/yanwinterr?igsh=MTVpbHUzcWo0bDB1Yg=="
            )
        )
    }
}