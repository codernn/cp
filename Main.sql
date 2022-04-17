SELECT courier_id, remarks, actual_delivered_date, delivered_branch_id WHERE actual_delivered_date=='****-**-14'

SELECT courier_id, from_address, to_address,booking_date actual_delivered_date from COURIER c, COURIER_STATUS cs WHERE c.courier_id = cs.courier_id ORDER BY courier_id DESC