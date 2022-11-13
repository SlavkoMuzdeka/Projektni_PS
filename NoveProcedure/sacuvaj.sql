CREATE DEFINER=`newuser`@`%` PROCEDURE `sacuvaj`(in id int, in tip boolean)
BEGIN
	if ((select Prisutan from dijete where id=OSOBA_IdOsobe) != tip) then
		update dijete set Prisutan=tip where OSOBA_IdOsobe=id;
        insert into vrijeme_dolaska_i_odlaska (DIJETE_OSOBA_IdOsobe, EvidentiranoVrijeme, Tip) values (id, now(), tip);
	end if;
END