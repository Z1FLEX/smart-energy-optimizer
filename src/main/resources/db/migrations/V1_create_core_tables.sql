CREATE TABLE organizations(
    id UUID primary key,
    name varchar(100) not null,
    address TEXT not null,
    industry_type varchar(100) not null,
    contact_email varchar(150) not null,
    contact_phone varchar(20) not null,
    subscription_plan varchar(50) not null,
    status varchar(30) not null,
    energy_cost_per_kwh DOUBLE PRECISION not null,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE users (
    id UUID PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    role VARCHAR(30) NOT NULL,
    phone_number VARCHAR(20),
    status VARCHAR(30) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_login TIMESTAMP,
    mfa_enabled BOOLEAN DEFAULT FALSE,
    organization_id UUID,
    CONSTRAINT fk_users_organization
        FOREIGN KEY (organization_id) REFERENCES organizations(id)
);

CREATE TABLE permissions (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL UNIQUE,
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE user_permissions (
    user_id UUID NOT NULL,
    permission_id UUID NOT NULL,
    assigned_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    assigned_by UUID,
    PRIMARY KEY (user_id, permission_id),

    CONSTRAINT fk_user_perm_user FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    CONSTRAINT fk_user_perm_permission FOREIGN KEY (permission_id) REFERENCES permissions(id) ON DELETE CASCADE
);

CREATE TABLE devices (
    id UUID PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    type VARCHAR(50) NOT NULL,
    model VARCHAR(100),
    serial_number VARCHAR(100),
    chip_id VARCHAR(100),
    mac_address VARCHAR(50),
    ip_address VARCHAR(50),
    location VARCHAR(150),
    watt_rating DOUBLE PRECISION,
    status VARCHAR(30) NOT NULL,
    certificate TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    organization_id UUID,
    CONSTRAINT fk_devices_organization FOREIGN KEY (organization_id) REFERENCES organizations(id)
);