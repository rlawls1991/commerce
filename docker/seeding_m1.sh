#!/bin/bash

set -e #Exit immediately if a command exits with a non-zero status.


mysql_sqls=(
    "mysql.sql"
    )

product=(
    "product.sql"
    )

review=(
    "review.sql"
    )

user=(
    "user.sql"
  )

escrow=(
    "escrow.sql"
  )

sqlExecute() {
	path=$1
	shift
	sqls=("${@}")

	for file in "${sqls[@]}"
	do
		echo "- import: /$path/$file"
		mysql --default-character-set=utf8 -uroot -p${MYSQL_ROOT_PASSWORD} < "/$path/$file"
	done
}

if [ ${1} == "mysqld" ]; then
sqlExecute "mysql" "${mysql_sqls[@]}"
fi

sqlExecute "product" "${product[@]}"
sqlExecute "review" "${review[@]}"
sqlExecute "user" "${user[@]}"
sqlExecute "escrow" "${escrow[@]}"