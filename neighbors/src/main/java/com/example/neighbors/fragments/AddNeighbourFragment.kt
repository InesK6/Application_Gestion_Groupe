package com.example.neighbors.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.URLUtil
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import com.example.neighbors.R
import com.example.neighbors.data.NeighborRepository
import com.example.neighbors.models.Neighbor
import com.google.android.material.textfield.TextInputLayout

class AddNeighbourFragment : Fragment(){
    private lateinit var enregistrerButton: Button
    private lateinit var Image: EditText
    private lateinit var Nom: EditText
    private lateinit var Numtel: EditText
    private lateinit var Wbste: EditText
    private lateinit var Adress: EditText
    private lateinit var Apropos: EditText
    private lateinit var telephoneLayout: TextInputLayout
    private lateinit var urlImage: TextInputLayout
    private lateinit var urlwebsite: TextInputLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_neighbor, container, false)
        enregistrerButton = view.findViewById(R.id.buttonEnregistrer)
        Image = view.findViewById(R.id.image1)
        Nom = view.findViewById(R.id.nom)
        Numtel = view.findViewById(R.id.telephone)
        Wbste = view.findViewById(R.id.webste)
        Adress = view.findViewById(R.id.adress)
        Apropos = view.findViewById(R.id.apropos)
        telephoneLayout=view.findViewById(R.id.tel)
        urlImage=view.findViewById(R.id.Image1)
        urlwebsite=view.findViewById(R.id.Webste)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        enregistrerButton.setOnClickListener {
            val idNew =NeighborRepository.getInstance().getNeighbours().size+1
            val lienImage = Image.text.toString()
            val nom = Nom.text.toString()
            val tel = Numtel.text.toString()
            val site = Wbste.text.toString()
            val adresse = Adress.text.toString()
            val apropos = Apropos.text.toString()
            var newNeighbor = Neighbor(idNew, nom, lienImage, adresse, tel, apropos, false, site)
            NeighborRepository.getInstance().createNeighbours(newNeighbor)
        }
        enregistrerButton.isEnabled = false
        Image.doAfterTextChanged {
            if (Image.text.isBlank() || URLUtil.isValidUrl(Image.text.toString())){
                urlImage.error = null
            } else {
                urlImage.error = getString(R.string.error_urlImage)
            }
            if (Image.text.isBlank() || Nom.text.isBlank() || Numtel.text.isBlank() || Wbste.text.isBlank() || Adress.text.isBlank() || Apropos.text.isBlank()){
                enregistrerButton.isEnabled = false
            }
            else{
                enregistrerButton.isEnabled = true
            }

        }
        Nom.doAfterTextChanged {
            if (Image.text.isBlank() || Nom.text.isBlank() || Numtel.text.isBlank() || Wbste.text.isBlank() || Adress.text.isBlank() || Apropos.text.isBlank()){
                enregistrerButton.isEnabled = false
            }
            else{
                enregistrerButton.isEnabled = true
            }

        }
        Numtel.doAfterTextChanged {
            with(Numtel.text.toString()) {
                if (isBlank( ) || ((startsWith("06") || startsWith("07")) && length == 10)){
                    telephoneLayout.error = null
                } else {
                    telephoneLayout.error = getString(R.string.error_tel)
                }
            }
            if (Image.text.isBlank() || Nom.text.isBlank() || Numtel.text.isBlank() || Wbste.text.isBlank() || Adress.text.isBlank() || Apropos.text.isBlank()){
                enregistrerButton.isEnabled = false
            }
            else{
                enregistrerButton.isEnabled = true
            }

        }
        Wbste.doAfterTextChanged {
            if (Wbste.text.isBlank() || URLUtil.isValidUrl(Wbste.text.toString())){
                urlwebsite.error = null
            } else {
                urlwebsite.error = getString(R.string.error_urlWeb)
            }
            if (Image.text.isBlank() || Nom.text.isBlank() || Numtel.text.isBlank() || Wbste.text.isBlank() || Adress.text.isBlank() || Apropos.text.isBlank()){
                enregistrerButton.isEnabled = false
            }
            else{
                enregistrerButton.isEnabled = true
            }

        }
        Adress.doAfterTextChanged {
            if (Image.text.isBlank() || Nom.text.isBlank() || Numtel.text.isBlank() || Wbste.text.isBlank() || Adress.text.isBlank() || Apropos.text.isBlank()){
                enregistrerButton.isEnabled = false
            }
            else{
                enregistrerButton.isEnabled = true
            }

        }
        Apropos.doAfterTextChanged {
            if (Image.text.isBlank() || Nom.text.isBlank() || Numtel.text.isBlank() || Wbste.text.isBlank() || Adress.text.isBlank() || Apropos.text.isBlank()){
                enregistrerButton.isEnabled = false
            }
            else{
                enregistrerButton.isEnabled = true
            }

        }



    }



}