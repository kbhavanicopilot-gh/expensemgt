-- PostgreSQL schema for EMS database
-- Generated from current database metadata

CREATE TABLE IF NOT EXISTS public.employee (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    department VARCHAR(100) NOT NULL,
    manager_id INTEGER,
    role VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT employee_email_key UNIQUE (email),
    CONSTRAINT employee_manager_id_fkey
        FOREIGN KEY (manager_id)
        REFERENCES public.employee (id)
);

CREATE TABLE IF NOT EXISTS public.expense (
    id SERIAL PRIMARY KEY,
    employee_id INTEGER NOT NULL,
    title VARCHAR(255) NOT NULL,
    total_amount NUMERIC(12,2) NOT NULL,
    status VARCHAR(50) NOT NULL DEFAULT 'PENDING',
    created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT expense_employee_id_fkey
        FOREIGN KEY (employee_id)
        REFERENCES public.employee (id)
);

CREATE TABLE IF NOT EXISTS public.expense_item (
    id SERIAL PRIMARY KEY,
    expense_id INTEGER NOT NULL,
    expense_type VARCHAR(100) NOT NULL,
    amount NUMERIC(12,2) NOT NULL,
    description TEXT,
    expense_date DATE NOT NULL,
    proof_file VARCHAR(500),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT expense_item_expense_id_fkey
        FOREIGN KEY (expense_id)
        REFERENCES public.expense (id)
);

CREATE TABLE IF NOT EXISTS public.approval (
    id SERIAL PRIMARY KEY,
    expense_id INTEGER,
    expense_item_id INTEGER,
    approver_id INTEGER NOT NULL,
    role VARCHAR(50) NOT NULL,
    status VARCHAR(50) NOT NULL DEFAULT 'PENDING',
    remarks TEXT,
    action_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT approval_expense_id_fkey
        FOREIGN KEY (expense_id)
        REFERENCES public.expense (id),
    CONSTRAINT approval_expense_item_id_fkey
        FOREIGN KEY (expense_item_id)
        REFERENCES public.expense_item (id),
    CONSTRAINT approval_approver_id_fkey
        FOREIGN KEY (approver_id)
        REFERENCES public.employee (id)
);
