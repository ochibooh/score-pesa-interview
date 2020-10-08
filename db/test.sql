/*
 * Copyright (c) 2020.
 *        Phelix Ochieng(ochibooh)
 * Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

select
       benefactors.name as Name,
       0 as Amount
from benefactors where benefactors.id not in (
    select
        benefactors.id
    from benefactors
             left join donations on benefactors.id = donations.benefactorId
    where donations.year = '2015'
    group by donations.benefactorId
)
union select
          case when benefactors.name is null then 'Anonymous' else benefactors.name end as Name,
          sum(donations.amount) as Amount
from donations
         left join benefactors on benefactors.id = donations.benefactorId
where donations.year = '2015'
group by donations.benefactorId