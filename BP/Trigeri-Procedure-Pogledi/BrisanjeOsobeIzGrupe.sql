use projektni_ps;

delimiter $$
create procedure delete_person_from_group (
	in id_osobe INT,
	   id_grupe INT,
       tip_osobe INT,
	out obrisan_status bool
)
begin
	set obrisan_status = false;
	if tip_osobe = 1 then
		delete from vaspitac_has_grupa where VASPITAC_OSOBA_IdOsobe = id_osobe AND GRUPA_IdGrupe = id_grupe;
        set obrisan_status = true;
	else
		delete from dijete_has_grupa where DIJETE_OSOBA_IdOsobe = id_osobe AND GRUPA_IdGrupe = id_grupe;
        set obrisan_status = true;
	end if;
        
end$$
delimiter ;