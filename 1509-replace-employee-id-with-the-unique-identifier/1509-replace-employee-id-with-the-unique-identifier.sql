SELECT 
    COALESCE(EU.unique_id, NULL) AS unique_id,
    E.name 
FROM 
    Employees E 
LEFT JOIN 
    EmployeeUNI EU 
ON 
    E.id = EU.id
ORDER BY 
    unique_id;
