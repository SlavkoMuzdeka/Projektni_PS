CREATE DEFINER=`root`@`localhost` PROCEDURE `add_activity_to_group`(
	in id_aktivnosti INT,
       id_grupe INT,
       datum_aktivnosti DATE,
       trajanje_aktivnosti INT,
	out je_dodana bool
)
begin
	set je_dodana = false;
	insert into aktivnost_has_grupa values(id_aktivnosti, id_grupe,datum_aktivnosti, trajanje_aktivnosti);
	set je_dodana = true;
    
end