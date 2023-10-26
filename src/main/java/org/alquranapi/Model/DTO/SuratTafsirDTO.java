package org.alquranapi.Model.DTO;

import java.util.ArrayList;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SuratTafsirDTO extends SuratDTO {
    private ArrayList<TafsirDTO> tafsir;
    private SuratPrevNextDTO suratSelanjutnya;
    private SuratPrevNextDTO suratSebelumnya;
}
