use projektni_ps;

delimiter $$
create procedure delete_activity_from_group (
	in id_aktivnosti INT,
	   id_grupe INT,
	out je_obrisana bool
)
begin
	set je_obrisana = false;
    delete from aktivnost_has_grupa where AKTIVNOST_IdAktivnosti = id_aktivnosti AND GRUPA_IdGrupe = id_grupe;
    set je_obrisana = true;
end$$
delimiter ;

call delete_activity_from_group(1, 1, @vrijednost);
select @vrijednost;