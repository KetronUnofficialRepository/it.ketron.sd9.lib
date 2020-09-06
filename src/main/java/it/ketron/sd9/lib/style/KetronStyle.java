package it.ketron.sd9.lib.style;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Data
@Slf4j
@NoArgsConstructor
@EqualsAndHashCode
public class KetronStyle {
    private String fileName;
    private short bpm;
    private boolean isDrumBoostActive; // ToDo: Move this parameter in the Drums channel

    Map<KetronTrackIdentifier, KetronTrack> ketronTrackList = new HashMap<>();
}
