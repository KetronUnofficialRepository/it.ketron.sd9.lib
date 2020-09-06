package it.ketron.sd9.lib.style;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
@EqualsAndHashCode
public class KetronChannel {
    int bank; // Assigned voice bank

    short volume;
    short pan;
    short rev;
    short cho;
    short efx;
    boolean mute;

    //ToDo: Midi event sequence (useful for previews?)
}
