package br.com.bauen.mainactivit.ultis

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

object MaskFormatUtil {

    const val FORMAT_CPF = "###.###.###-##"
    const val FORMAT_CNPJ = "##.###.###/####-##"
    const val FORMAT_RG = "##.###.###-#"
    const val FORMAT_CEP = "#####-###"
    const val FORMAT_DATE = "##/##/####"
    const val FORMAT_HOUR = "##:##"
    const val FORMAT_FONE_COD_AREA = "(##) ####-#####"
    const val FORMAT_FONE_COD_COMP = "+##(##)####-#####"
    const val FORMAT_FONE = "#####-####"
    const val FORMAT_COD_PAIS = "+##"
    const val FORMAT_COD_AREA = "(##)"

    fun mask(ediTxt: EditText, mask: String): TextWatcher {
        return object : TextWatcher {
            var isUpdating = false
            var old = ""
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                val str = unmask(s.toString())
                var mascara = ""
                if (isUpdating) {
                    old = str
                    isUpdating = false
                    return
                }
                var i = 0
                for (m in mask.toCharArray()) {
                    if (m != '#' && str.length > old.length) {
                        mascara += m
                        continue
                    }
                    mascara += try {
                        str[i]
                    } catch (e: Exception) {
                        break
                    }
                    i++
                }
                isUpdating = true
                ediTxt.setText(mascara)
                ediTxt.setSelection(mascara.length)
            }
        }
    }

    fun unmask(s: String): String {
        return s.replace("[.]".toRegex(), "")
            .replace("[-]".toRegex(), "")
            .replace("[/]".toRegex(), "")
            .replace("[(]".toRegex(), "")
            .replace("[ ]".toRegex(), "")
            .replace("[:]".toRegex(), "")
            .replace("[)]".toRegex(), "")
            .replace("[+]".toRegex(), "")
    }
}