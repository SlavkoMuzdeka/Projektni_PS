use projektni_ps;

create trigger increment_number_of_members1 after insert
on vaspitac_has_grupa
for each row
update grupa
set BrojClanova = BrojClanova + 1
where IdGrupe = new.GRUPA_IdGrupe;

create trigger incremet_number_of_members2 after insert
on dijete_has_grupa
for each row
update grupa
set BrojClanova = BrojClanova + 1
where IdGrupe = new.GRUPA_IdGrupe;

create trigger decrement_number_of_members1 after delete
on vaspitac_has_grupa
for each row
update grupa
set BrojClanova = BrojClanova - 1
where IdGrupe = old.GRUPA_IdGrupe;

create trigger decrement_number_of_members2 after delete
on dijete_has_grupa
for each row
update grupa
set BrojClanova = BrojClanova - 1
where IdGrupe = old.GRUPA_IdGrupe;
